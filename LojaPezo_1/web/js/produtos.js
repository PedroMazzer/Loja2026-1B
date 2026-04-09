document.querySelectorAll('.btn-adicionar').forEach(function(btn) {
    btn.addEventListener('click', function() {
        var td = btn.closest('td');
        var qtd = td.querySelector('.qtd').value;
        var nome = btn.getAttribute('data-nome');
        var preco = btn.getAttribute('data-preco');

        if (parseInt(qtd) <= 0) {
            alert('Quantidade inválida!');
            return;
        }

        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'Comprar', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
        xhr.send('nome=' + encodeURIComponent(nome) +
                 '&preco=' + encodeURIComponent(preco) +
                 '&quantidade=' + encodeURIComponent(qtd));
    });
});
