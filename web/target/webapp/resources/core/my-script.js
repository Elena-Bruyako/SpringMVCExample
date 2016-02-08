/**
 * Created by brunyatko on 04.02.16.
 */
$(document).ready(function(){

    function getRow (data) {
//        {name: "name", good_id: 'good_id', price: 'price'};

        var string = '<tr>' +
        '<td>{{good_id}}</td>'+
        '<td>{{name}}</td>' +
            '<td>{{price}}</td>' +
        '<td>' +
        '<button class="btn btn-default" data-toggle="modal" data-target="#requestModal">Edit</button>' +
        '<a href="delete/{{good_id}}">Delete</a>' +
        '</td>' +
        '</tr>';

        string = string.replace('{{good_id}}', data.good_id);
        string = string.replace('{{name}}', data.name);
        string = string.replace('{{price}}', data.price);

        return string;
    }

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
            data: JSON.stringify({"good_id": good_id, "name": name, "price": price}),
            success: function(data) {
                $('#main-table').append(getRow(data));
            },
            error: function (req, message) {
                var data = {good_id: good_id, name: name, price: price};
                $('#main-table').append(getRow(data));
            }
        });
    });

    $('#update').click(function() {
        var good_id = parseInt($('#newId').val());
        var editNewName = $('#editName').val();
        var editNewPrice = parseInt($('#editPrice').val());
        $.ajax({
            type: "POST",
            url: 'update',
            contentType: "application/json",
            dataType: "json",
            processData: false,
            data: JSON.stringify({"good_id" : good_id, "name": editNewName, "price": editNewPrice}),
            success: function (updatedData) {
                var $row = $('#good-' + updatedData.good_id);
                $row.find('.name').val(updatedData.name);
                $row.find('.price').val(updatedData.price);
            },
            error: function () {

            }
        });
        $('#requestModal').modal('toggle');
    });

    $('#main-table').on('click', '.edit', function (event) {
        var id = $(this).closest('tr').find('.good_id').text();
        $('#newId').val(id);
    });
});