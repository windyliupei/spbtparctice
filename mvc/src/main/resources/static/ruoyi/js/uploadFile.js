
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
        },
        error: function (err) {
        }
    });

}
