var xHRObject = new XMLHttpRequest();

function getData() {
    if (xHRObject.readyState == 4 && xHRObject.status == 200) {
        var xmlDoc = xHRObject.responseXML;
        var xsltProcessor = new XSLTProcessor();
        // Load XSL
        XObject = new XMLHttpRequest();
        XObject.open("GET", "styleXML.xsl", false);
        XObject.send(null);
        xslStylesheet = XObject.responseXML;
        xsltProcessor.importStylesheet(xslStylesheet);
        // Transform
        var fragment = xsltProcessor.transformToFragment(xmlDoc, document);
        console.log(fragment);
        document.getElementById("letra_a").innerHTML = "";
        document.getElementById("letra_a").appendChild(fragment);
//        registerEvents(); 
        // Clear the object and call the getDocument function in 10 seconds
        xHRObject.abort();
    }
}

function getDocument() {
    // Reset the function
    xHRObject.onreadystatechange = getData;
    // IE will cache the GET request; the only way around this is to append a
    // different querystring. We add a new date and append it as a querystring
    xHRObject.open("GET", "cd_catalog.xml", true);
    xHRObject.send(null);
}

onload = getDocument;