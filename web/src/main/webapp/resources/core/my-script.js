/**
 * Created by brunyatko on 04.02.16.
 */
$(document).ready(function(){

    $('#main-table').on('click', '#tableBody .js-edit', function () {

        showEditControls();

        var name = $(this).closest('tr').find('.name').html();
        var price = $(this).closest('tr').find('.price').html();
        var id = $(this).closest('tr').find('.goodId').html();
        $('#newName').val(name);
        $('#newPrice').val(price);
        $('#newGoodId').val(id);
    });

    $('#main-table').on('click', '#tableBody .js-delete', function () {
        var id = $(this).closest('tr').find('.goodId').html();
        sendAjax('delete', JSON.stringify({"goodId": id}), 'POST');
    });

    $('#add').click(function(){
        var name = $('#newName').val();
        var price = parseInt($('#newPrice').val());
        sendAjax('add', JSON.stringify({"name": name, "price": price}), 'POST');

        $('#newName').val('');
        $('#newPrice').val('');
    });

    $('#cancel').click(function() {
        hideEditControls();
    });

    $('#update').click(function() {
        var editNewName = $('#newName').val();
        var editNewPrice = parseInt($('#newPrice').val());
        var id = parseInt($('#newGoodId').val());
        sendAjax('update', JSON.stringify({"goodId": id,  "name": editNewName, "price": editNewPrice}), 'POST');

        hideEditControls();
    });

    $('#getByFilter').click(function() {
        var selectPriceFrom = parseInt($('#priceFrom').val());
        var selectPriceTo = parseInt($('#priceTo').val());
        var selectByName = $('#selectName').val();

        sendAjax('getByFilter', {"selectPriceFrom": selectPriceFrom, "selectPriceTo": selectPriceTo, "selectByName": selectByName}, 'GET');
    });

    $('#resetFilter').click(function(){
        $('#priceFrom').val('');
        $('#priceTo').val('');
        $('#selectName').val('');

        sendAjax('getAll', '', 'GET');
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

    function hideEditControls(){
        $('#add').show();
        $('#update').hide();
        $('#cancel').hide();
        $('#newName').val('');
        $('#newPrice').val('');
    }

    function showEditControls(){
        $('#add').hide();
        $('#update').show();
        $('#cancel').show();
    }
});