<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:param name="uf" select="ac" />
    <xsl:template match="/">
        <xsl:for-each select="//estado[@id=$uf]/cidade">
            <xsl:sort select="." />
            <option value="{@codigo}"><xsl:value-of select="@name" /></option>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>
