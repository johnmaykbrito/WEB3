<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <xsl:for-each select="root/estado">
            <xsl:sort select="@name" />
            <option value="{@id}"><xsl:value-of select="@name" /></option>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>
