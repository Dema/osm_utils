import java.text._
import java.util._

val df = new DecimalFormat("###.#######",DecimalFormatSymbols.getInstance(Locale.US))

val Coords = "(\\w)(\\d+)[°.*\" ]+([\\d.]+)[\'`]*\\s+(\\w)(\\d+)[°.*\" ]+([\\d.]+)[\'`]*".r

val genNode = args.length > 0 && args(0)== "n"

var i = -1

while(true){
    val string = readLine.trim //args.toList.mkString(" ")
    if(string == null){exit(0)}
    string match {
    case Coords(latType, latDegree, latMinutes, lonType, lonDegree, lonMinutes) => 
	val lat = df.format(latDegree.toDouble+latMinutes.toDouble/60)
	val lon = df.format(lonDegree .toDouble+ lonMinutes.toDouble/60)
	if(genNode){
	        print(<node id={i.toString} lat={lat} lon={lon} visible='true'/> )
	        i -=1
	}else{
	    println("LAT: "+lat+" LON: "+ lon)
	}
    case z => println ("Не знаю: "+z)
    }
}
