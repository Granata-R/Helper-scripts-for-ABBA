// 5. Import single slice annotations.

import ij.gui.Wand
import qupath.lib.objects.PathObjects
import qupath.lib.regions.ImagePlane
import ij.IJ
import ij.process.ColorProcessor
import qupath.imagej.processing.RoiLabeling
import qupath.imagej.tools.IJTools
import java.util.regex.Matcher
import java.util.regex.Pattern
import groovy.io.FileType
import qupath.lib.io.GsonTools // +

ImagePlane plane = ImagePlane.getDefaultPlane()

server = getCurrentServer()
path = server.getPath()

name = GeneralTools.getNameWithoutExtension(server.getMetadata().getName()) // Useless

mask = buildFilePath(PROJECT_BASE_DIR, 'Atlas_annotations', File.separator)

def list = []
def dir = new File(mask)
dir.eachFileRecurse (FileType.FILES) { file ->
  list << file
}

for(int kk = 0; kk < list.size(); kk++) {
	def a = list[kk]
	print(a)

	// Instantiate tools.
	def gson = GsonTools.getInstance(true)
	// Prepare template.
	def type = new com.google.gson.reflect.TypeToken<List<qupath.lib.objects.PathObject>>() {}.getType();
	//def json_fp = promptForFile(null)
	def json_fp = a
	print(json_fp)

	def b = a.toString()
	print(b)

	def c = b.substring(b.lastIndexOf(File.separator)+1)
	print(c)

	def d = c.replace(".geojson", "");
	d = d.replace("(", "");
	d = d.replace(")", "");
	//d = d.replace(",", "");
	print(d)

	e = d.replaceAll(".+Rectangle ", "");
	System.out.println(e);
	print(e)

	def f = e.split(',').collect{it as int}

	// Read annotations.
	bufferedReader = new BufferedReader(new FileReader(json_fp))
	deserializedAnnotations = gson.fromJson(bufferedReader.text, type)

	// Add to dataset.
	addObjects(deserializedAnnotations)

	// Select and undo downscale.
	selectObjects(deserializedAnnotations)
	// Scale all selected annotations of a given factor
	double scale_X = 20// Edit this value to change width (X)
	double scale_Y = 20// Edit this value to change height (Y)
	// Get annotations
	def annotation = getSelectedObjects()
	def sz = annotation.size()

	// Scale.
	double t_x = f[0] /19 *-1
	double t_y = f[1] /19 *-1
	print(t_x)
	print(t_y)

	for(int i = 0; i < sz; i++) { 
		def as = annotation[i]
		def roi = as.getROI()
		def roiScaled = roi.scale(scale_X, scale_Y, t_x, t_y)
		as.setROI(roiScaled)
		sz = annotation.size() // Update after deletion
	} 

	// Resolve hierarchy.
	resolveHierarchy()
	   
	print "Atlas annotations  imported. Wait for others..."
}
print "Done!"