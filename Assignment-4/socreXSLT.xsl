<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes" standalone="yes"></xsl:output>

    <xsl:template match="学生列表">
        <xsl:element name="课程成绩列表">
            <xsl:for-each select="学生/课程成绩列表/课程成绩">
                <xsl:sort select="课程名称"></xsl:sort>
                <xsl:sort select="成绩性质"></xsl:sort>
                <xsl:sort select="成绩/得分"></xsl:sort>
                <xsl:sort select="parent::*/preceding-sibling::*[2]/学号"></xsl:sort>
                <xsl:element name="课程成绩">
                    <xsl:element name="成绩">
                        <xsl:element name="学号"><xsl:value-of select="成绩/学号"/></xsl:element>
                        <xsl:element name="得分"><xsl:value-of select="成绩/得分"/></xsl:element>
                    </xsl:element>
                    <xsl:element name="课程名称">
                        <xsl:value-of select="课程名称"/>
                    </xsl:element>
                    <xsl:element name="课程编号">
                        <xsl:value-of select="课程编号"/>
                    </xsl:element>
                    <xsl:element name="成绩性质">
                        <xsl:value-of select="成绩性质"/>
                    </xsl:element>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>


</xsl:stylesheet>