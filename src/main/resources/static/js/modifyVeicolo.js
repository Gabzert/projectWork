
$('document').ready(function(){

    $('#editButton').on('click',function(event){

        var href = $(this).attr('href');

        $.get(href, function(veicolo) {
            $('#id').val(veicolo.id);
            $('#marca').val(veicolo.marca);
            $('#modello').val(veicolo.modello);
            $('#prezzo').val(veicolo.prezzo);
            $('#immagine').val(veicolo.immagine);
            $('#descrizione').val(veicolo.descrizione);
        });

        $('update').modal();
    });


});