var xhr = new XMLHttpRequest();
var xml;
function mostrarErros() {
    if (xhr.readyState === 4) {
        var obj = JSON.parse(xhr.responseText);
        for (var prop in obj) {
            var msg = document.getElementById(prop);
            msg.textContent = obj[prop];
        }
    }
}
function validar() {
    xhr.open("post", "ServletValidar");
    xhr.onreadystatechange = mostrarErros;
    var formData = new FormData(document.forms[0]);
    xhr.send(formData);
}
function preencher() {
    if (xhr.readyState === 4) {
        xml = xhr.responseXML;
        var form = document.forms[0];
        var xsltProcessor = new XSLTProcessor();
        var xsl = new XMLHttpRequest();
        xsl.open("get", "estados.xsl");
        xsl.onreadystatechange = function () {
            if (xsl.readyState === 4) {
                var xslt = xsl.responseXML;
                xsltProcessor.importStylesheet(xslt);
                var result = xsltProcessor.transformToFragment(xml, document);
                form.estado.appendChild(result);
                preencherCidades();
            }
        };
        xsl.send();
    }
}
function preencherCidades() {
    var form = document.forms[0];
    var estado = form.estado.value;
    var xsltProcessor = new XSLTProcessor();
    var xsl = new XMLHttpRequest();
    xsl.open("get", "cidades.xsl");
    xsl.onreadystatechange = function () {
        if (xsl.readyState === 4) {
            var xslt = xsl.responseXML;
            xsltProcessor.importStylesheet(xslt);
            xsltProcessor.setParameter(null, "uf", estado);
            var result = xsltProcessor.transformToFragment(xml, document);
            form.cidade.innerHTML = "";
            form.cidade.appendChild(result);
        }
    };
    xsl.send();
}
function registerEvents() {
    var inputs = document.getElementsByTagName("input");
    for (let elem of inputs) {
        elem.addEventListener("blur", validar);
    }
    xhr.open("get", "cidades.xml");
    xhr.onreadystatechange = preencher;
    xhr.send();
    document.getElementsByName("estado")[0].onchange = preencherCidades;
}
onload = registerEvents;