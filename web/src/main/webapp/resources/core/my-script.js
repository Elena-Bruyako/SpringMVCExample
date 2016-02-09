/**
 * Created by brunyatko on 04.02.16.
 */
$(document).ready(function(){

    $('#add').click(function(){
        var name = $('#newName').val();
        var price = parseInt($('#newPrice').val());
        sendAjax('add', JSON.stringify({"name": name, "price": price}), 'POST');
    });

    $('#tableBody .js-edit').click(function() {
        var name = $(this).closest('tr').find('.name').html();
        var price = $(this).closest('tr').find('.price').html();
        var id = $(this).closest('tr').find('.goodId').html();
        $('#add').hide();
        $('#update').show();
        $('#cancel').show();
        $('#newName').val(name);
        $('#newPrice').val(price);
        $('#newGoodId').val(id);
    });

    $('#cancel').click(function() {
        $('#add').show();
        $('#update').hide();
        $('#cancel').hide();
        $('#newName').val('');
        $('#newPrice').val('');
    });


    $('#update').click(function() {
        var editNewName = $('#newName').val();
        var editNewPrice = parseInt($('#newPrice').val());
        var id = parseInt($('#newGoodId').val());
        sendAjax('update', JSON.stringify({"goodId": id,  "name": editNewName, "price": editNewPrice}), 'POST');

    });

    $('#tableBody .js-delete').click(function() {
        var id = $(this).closest('tr').find('.goodId').html();
        sendAjax('delete', JSON.stringify({"goodId": id}), 'POST');
    });

    $('#getByFilter').click(function() {
        var selectPriceFrom = parseInt($('#priceFrom').val());
        var selectPriceTo = parseInt($('#priceTo').val());
        var selectByName = $('#selectName').val();
        sendAjax('/getByFilter', JSON.stringify({"priceFrom": selectPriceFrom, "priceTo": selectPriceTo, "name": selectByName}), 'POST');
    });

    function sendAjax(url, data, method) {
        $.ajax({
            type: method,
            url: url,
            contentType: "application/json",
            dataType: "text",
            data: data,
            success: function(data) {
                $('#tableBody').empty().append($(data));
            },
            error: function() {
                $('#tableBody').append("Error!");
            }
        });
    }

    $('#main-table').on('click', '.edit', function (event) {
        var id = $(this).closest('tr').find('.good_id').text();
        $('#newId').val(id);
    });
});