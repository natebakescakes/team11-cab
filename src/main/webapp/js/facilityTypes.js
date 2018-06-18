$(document).ready(function() {
  var v = window.contextRoot + '/json/showfacilitytypes';
  var token = $('#_csrf').attr('content');
  var header = $('#_csrf_header').attr('content');

  $.ajaxSetup({
    beforeSend: function(xhr) {
      xhr.setRequestHeader('X-CSRF-TOKEN', token);
    },
  });

  var $table = $('#facilityTypesTable');

  var simple_checkbox = function(data, type, full, meta) {
    var checked = data == true ? 'checked' : '';
    return (
      '<input type="checkbox"  disabled="true" class="checkbox td-button" ' +
      checked +
      '/>'
    );
  };

  var datatbl = $table.DataTable({
    ajax: {
      url: v,
      dataSrc: '',
    },
    columns: [
      {
        data: 'typeId',
      },
      {
        data: 'typeName',
      },
      {
        data: 'description',
      },
      {
        defaultContent:
          "<button class='td-button btn-edit btn btn-table btn-primary'>Edit</button>",
      },
    ],
  });

  $('#facilityTypesTable tbody').on('click', '.btn-edit', function(e) {
    var data = datatbl.row($(this).parents('tr')).data();
    var counter = 0;

    $($(this).parents('tr'))
      .find('td')
      .each(function() {
        counter++;
        if (counter < 2) {
          return;
        }
        if (
          $(this)
            .children()
            .hasClass('checkbox')
        ) {
          $(this)
            .find('input')
            .prop('disabled', false);
        }
        if (
          !$(this)
            .children()
            .hasClass('td-button')
        ) {
          var text = $(this).text();
          $(this).html('<input type="text" value="' + text + '">');
        }
        if (
          $(this)
            .children()
            .hasClass('btn-edit')
        ) {
          $(this).html(
            '<button class="td-button btn-save btn btn-table btn-primary">Submit</button>'
          );
        }
      });
  });

  $('#facilityTypesTable tbody').on('click', '.btn-save', function(e) {
    var parenttr = $(this).parents('tr');
    var counter = 0;
    $($(this).parents('tr'))
      .find('td')
      .each(function() {
        counter++;
        if (counter < 2) {
          return;
        }

        if (
          $(this)
            .children()
            .hasClass('checkbox')
        ) {
          $(this)
            .find('input')
            .prop('disabled', true);

          if (
            $(this)
              .find('input')
              .prop('checked') == true
          ) {
            var cell = datatbl.cell($(this));

            cell.data(1).draw();
          } else {
            var cell = datatbl.cell($(this));
            cell.data(0).draw();
          }
        }

        if (
          !$(this)
            .children()
            .hasClass('td-button')
        ) {
          var text = $(this)
            .find('input')
            .val();
          $(this).text(text);
          var cell = datatbl.cell($(this));
          cell.data(text).draw();
        }

        if (
          $(this)
            .children()
            .hasClass('btn-save')
        ) {
          $(this).html(
            '<button class="td-button btn-edit btn btn-table btn-primary">Edit</button>'
          );
        }
      });

    var facilitydata = datatbl.row(parenttr).data();

    $.ajax({
      url: window.contextRoot + '/admin/facilities/types/update',
      type: 'POST',
      data: JSON.stringify(facilitydata),
      contentType: 'application/json',
      cache: true,
      success: function(data) {
      },
    });
  });

  $('#myFacTable tbody').on('click', '.btn-delete', function(e) {
    var data = datatbl.row($(this).parents('tr')).data();
  });
});
