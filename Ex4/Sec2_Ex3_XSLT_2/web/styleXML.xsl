<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    <xsl:output method="html"/>
    <xsl:template match="/">
        <div id="albuns">
            <xsl:for-each select="//cd[artist[starts-with(., 'A')]]">
                <a href="{title}.htm">
                    <xsl:value-of select="title" />
                    <br />
                    -<xsl:value-of select="artist" />
                    <br />
                    -<xsl:value-of select="country" />
                    <br />
                    -<xsl:value-of select="company" />
                    <br />
                    -<xsl:value-of select="price" />
                    <br />
                    -<xsl:value-of select="year" />
                </a>
                <br />
                <br />
            </xsl:for-each>
        </div>
        <xsl:call-template name="b"/>
        <xsl:call-template name="c"/>
        <xsl:call-template name="d"/>
    </xsl:template>
    
    <xsl:template name="b">
        <h1>Letra b</h1>
        <div>
            O preço total aproximado é
            <xsl:value-of select="sum(//cd/price)"/>
            reais.
        </div>
    </xsl:template>
    
    <xsl:template name="c">
        <h1>Letra c</h1>
        <div>
            <xsl:for-each select="//cd">
                <xsl:sort select="year" order="ascending"/>
                <ul>
                    <xsl:if test="position() = 1">
                        <li>
                            <xsl:value-of select="title"/>
                        </li>
                        <li>
                            <xsl:value-of select="artist"/>
                        </li>
                        <li>
                            <xsl:value-of select="year"/>
                        </li>
                        <li>
                            <xsl:value-of select="price"/>
                        </li>
                    </xsl:if>
                </ul>
            </xsl:for-each>
        </div>
    </xsl:template>
    
    <xsl:template name="d">
        <h1>Letra d</h1>
        <div>
            Existem
            <xsl:value-of select="count(//cd/title[starts-with(., 'F')] | //cd/title[starts-with(., 'M')])"/>
            álbuns que começam com F ou M.
            São eles:
            <ul>
                <xsl:for-each select="//cd/title[starts-with(., 'F')] | //cd/title[starts-with(., 'M')]">
                    <li>
                        <xsl:value-of select="../title"></xsl:value-of>
                    </li>
                </xsl:for-each>
            </ul>
        </div>
    </xsl:template>
    
</xsl:stylesheet>