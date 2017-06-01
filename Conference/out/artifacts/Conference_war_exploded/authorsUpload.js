/**
 * Created by Viman Adrian on 31.05.2017.
 */

$(document).ready(function () {
    $('#upload-form').ajaxForm({
        success: function(msg) {
            alert("File has been uploaded successfully");
        },
        error: function(msg) {
            $("#upload-error").text("Couldn't upload file");
        }
    });
});
