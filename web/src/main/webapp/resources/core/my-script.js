/**
 * Created by brunyatko on 04.02.16.
 */
$(document).ready(function(){

    $('#addNewGoods').click(function(){
        var good_id = parseInt($('#newId').val());
        var name = $('#newName').val();
        var price = parseInt($('#newPrice').val());
        $.ajax({
            type: "POST",
            url: 'addNewGoods',
            contentType: "application/json",
            dataType: "json",
            processData: false,
            data: JSON.stringify({"good_id": good_id, "name": name, "price": price})
        });
    });

});