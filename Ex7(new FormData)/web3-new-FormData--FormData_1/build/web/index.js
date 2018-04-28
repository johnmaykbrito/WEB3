function call(event) {
    var xhr = new XMLHttpRequest();
    var data = new FormData(document.forms['meuform']);
    xhr.open("POST", "ServletAjax", true);
    xhr.send(data);
    xhr.onreadystatechange = function () {
        alert("estado->" + xhr.readyState);
        if (xhr.readyState === 4) {
            var txt = xhr.responseText;
            var msg = txt;
            alert(txt);
            var p = document.querySelector("h1");
            p.innerHTML = msg;
        }
    };
    event.preventDefault();
}

function init() {
    var form = document.forms[0];
    form.onsubmit = call;
}

onload = init;
