
$("#upload").click(function(){
    uploadOfficeFile();
});

function uploadOfficeFile() {


    $.ajax({
        url: "/read ",
        type: 'POST',
        cache: false,
        data: new FormData($("#uploadForm")[0]),
        processData: false,
        contentType: false,
        success: function (result) {
            
            if (result.code==0){
                var dataResult = result.data;
                goRedir(dataResult);
                window.location.href = "/writeExcelCtl";
            }
            
        },
        error: function (err) {
        }
    });

}

function goRedir(dataResult) {
    $.ajax({
        url: "/writeExcel",
        type: 'POST',
        data:dataResult,
        contentType : 'application/json;charset=utf-8',
        dataType : 'json',
        success: function (result) {
            var  a = result;
        },
        error: function (err) {
            var  a = err;
        }
    });
}
