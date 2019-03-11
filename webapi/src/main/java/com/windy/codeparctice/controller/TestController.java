package com.windy.codeparctice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping(value = "/v1/api/test")
public class TestController {

    Semaphore semaphore=new Semaphore(1);  //定义资源的总数量,同时只能一个线程操作。
    /*AtomicLong orderCount = new AtomicLong(65535L);*/


    @Autowired
    FakeDatabase fakeDatabase;

    //先发5000，再发1000,结果是999，998，后访问的得到的是998，结果正确
    //http://localhost:8082/v1/api/test/sync/5000
    //http://localhost:8082/v1/api/test/sync/1000
    @GetMapping("/sync/{sleep}")
    @ResponseBody
    public Object syncTest(@PathVariable("sleep") int sleep){
        /*int availablePermits=semaphore.availablePermits();
        if(availablePermits>0){
            System.out.println("获得到资源");
        }else{
            System.out.println("资源已被占用，等待释放...");
        }*/
        try {
            //尝试请求一个资源
            System.out.println("尝试请求一个资源");
            //请求占用一个资源
            semaphore.acquire(1);
            System.out.println("得倒资源并使用");
            doSomethingSync(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            //释放一个资源
            semaphore.release(1);
        }
        return fakeDatabase.getCount();
    }

    private void doSomethingSync(int sleep) throws InterruptedException {
        //模拟读取数据库
        Thread.sleep(1000);
        Long currentCount = fakeDatabase.getCount();
        currentCount--;
        //模拟存储数据库
        Thread.sleep(sleep);
        fakeDatabase.setCount(currentCount);
    }

    //先发5000，再发1000，会同样得到 999
    // http://localhost:8082/v1/api/test/async/5000
    //http://localhost:8082/v1/api/test/async/1000
    @GetMapping("/async/{sleep}")
    @ResponseBody
    public Object asyncTest(@PathVariable  int sleep){
        try {
            doSomethingSync(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
        }
        return fakeDatabase.getCount();
    }


}
