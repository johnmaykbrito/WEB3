var xhr = new XMLHttpRequest();
function mostrarLista(ok) {
    var tabela = document.getElementById("lista");
    var formulario = document.getElementById("formulario");
    if (ok) {
        tabela.style.display = "table";
        formulario.style.display = "none";
    } else {
        tabela.style.display = "none";
        formulario.style.display = "block";
    }
}
function mostrarListaFuncionarios() {
    mostrarLista(true);
    var lista = document.querySelector("table#lista tbody");
    lista.innerHTML = "";
}
function mostrarAlterar() {
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            var text = xhr.responseText;
            var func = JSON.parse(text);
            var form = document.getElementById("form");
            form.nome.value = func.nome;
            var date = func.dataNascimento.split(" ");
            var data = new Date(date[1] + " " + date[2] + ", " + date[5] + " " + date[3]);
            form.dataNascimento.value = data.getDate() + "/" + (data.getMonth() + 1) + "/" + data.getFullYear();
            form.salario.value = func.salario;
            form.codigo.value = func.codigo;
            form.submeter.value = "Alterar";
            mostrarLista(false);
        }
    };
    var params = "codigo=" + encodeURIComponent(this.value);
    xhr.open("post", "Exemplo6c", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(params);
}
function remover() {
    xhr.onreadystatechange = tratarColecao;
    var params = "codigo=" + encodeURIComponent(this.value);
    xhr.open("post", "Exemplo6e", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(params);
}
function registerEvents() {
    var alterar = document.querySelectorAll("input[type='image'][title='Alterar']");
    if (alterar !== null) {
        Array.prototype.forEach.call(alterar, function (a) {
            a.onclick = mostrarAlterar;
        });
    }
    var excluir = document.querySelectorAll("input[type='image'][title='Remover']");
    if (excluir !== null) {
        Array.prototype.forEach.call(excluir, function (a) {
            a.onclick = remover;
        });
    }
}
function tratarColecao() {
    if (xhr.readyState === 4) {
        mostrarListaFuncionarios();
        var tbody = document.querySelector("table#lista tbody");
        var text = xhr.responseText;
        var lista = JSON.parse(text);
        if (lista.length > 0) {
            for (var i = 0; i < lista.length; i++) {
                var func = lista[i];
                var date = func.dataNascimento.split(" ");
                var data = new Date(date[1] + " " + date[2] + ", " + date[5] + " " + date[3]);
                var linha = "<td>";
                linha += "<input type='image' title='Alterar' src='imgs/alterar.png' value='" + func.codigo + "' />";
                linha += "<input type='image' title='Remover' src='imgs/remover.png' value='" + func.codigo + "' />";
                linha += "</td><td>" + func.nome + "</td><td>" + data.getDate() + "/" + (data.getMonth() + 1) + "/" + data.getFullYear() + "</td><td>" + func.salario + "</td>";
                var newChild = document.createElement("tr");
                tbody.appendChild(newChild);
                newChild.innerHTML = linha;
            }
        } else {
            var tr = document.createElement("tr");
            tbody.appendChild(tr);
            tr.innerHTML = "<th colspan='4'>Nao existem funcionarios cadastrados.</th>";
        }
        registerEvents();
    }
}
function listarFuncionarios() {
    xhr.onreadystatechange = tratarColecao;
    xhr.open("get", "Exemplo6a", true);
    xhr.send(null);
}
function mostrarInserir() {
    mostrarLista(false);
    var form = document.getElementById("form");
    form.reset();
}
function submeter() {
    xhr.onreadystatechange = tratarColecao;
    var form = document.getElementById("form");
    var formData = new FormData(form);
    if (form.submeter.value === "Alterar") {
        xhr.open("post", "Exemplo6d", true);
    } else {
        xhr.open("post", "Exemplo6b", true);
    }
    form.submeter.value = "Inserir";
    xhr.send(formData);
    return false;
}
function addEvents() {
    listarFuncionarios();
    var inserir = document.getElementById("inserir");
    inserir.onclick = mostrarInserir;
    var form = document.getElementById("form");
    form.onsubmit = submeter;
}
onload = addEvents;