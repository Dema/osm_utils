val from = xml.XML.loadFile(args(0))

var id = 0

val z = from \\ "wpt"

val z2 = z.map( wpt => <node id={id -= 1; id.toString} lat={wpt \ "@lat"} lon={wpt \ "@lon"} visible="true">
<tag k="name" v={(wpt \ "desc") .text.substring(4)} />
<tag k="amenity" v="fuel" />
</node>
)

val to=
<osm version='0.6' generator='JOSM'>
{z2}
</osm>


xml.XML.saveFull("out.osm",to,"UTF-8",true,null)