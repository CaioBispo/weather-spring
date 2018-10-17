var URL_IMG = "http://openweathermap.org/img/w/[[ICONE]].png";

$(function () {

        $('#form-previsao').submit(function (e) {
            e.preventDefault();
            var cidade = $('#cidade').val();

            $.ajax({
                url: 'http://127.0.0.1:8080/' + cidade,
                method: 'GET',
                success: function (weather) {
                    $('#semana').html('');
                    var hoje = weather.shift();

                    var template = $('#hoje').clone();

                    $('.data').html(hoje.dataFormatada);
                    $('.temperatura-maxima').html(hoje.tempMax);
                    $('.temperatura-minima').html(hoje.tempMin);
                    $('.icone').attr('src', 'http://openweathermap.org/img/w/'+hoje.icon+'.png');
                    $('.condicao').html(hoje.condition);

                    $.each(weather, function(i, item) {

                        var templateNovo = template.clone();

                        $(templateNovo).find('.data').html(item.dataFormatada);
                        $(templateNovo).find('.temperatura-maxima').html(item.tempMax);
                        $(templateNovo).find('.temperatura-minima').html(item.tempMin);
                        $(templateNovo).find('.icone').attr('src', 'http://openweathermap.org/img/w/'+item.icon+'.png');
                        $(templateNovo).find('.condicao').html(item.condition);

                        $('#semana').append(templateNovo);
                    });
                }
            });
        });

});