<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" />
	<xsl:template match="/">
	<html>
<body>
<h2>My CD Collection</h2>
<table>
<tr>
<th>Title</th>
<th>Artist</th>
</tr>

<xsl:for-each select="/main/persona">
<tr>
<td><xsl:value-of select="nombre"/></td>
</tr>
</xsl:for-each>
</table>
</body>
</html>
		
	</xsl:template>
</xsl:stylesheet>