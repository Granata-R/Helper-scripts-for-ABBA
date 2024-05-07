// 1. Create rectangular annotations encompassing single brain slices.

NUMBER_OF_SLICES= 4 // Change this number with the number of slices you want to process.

import static qupath.lib.gui.scripting.QPEx.*
import qupath.lib.roi.RectangleROI
import qupath.lib.objects.PathAnnotationObject

// Set size in pixels at the base resolution.
int x = 16500
int y = 11000

// Get center pixel.
def viewer = getCurrentViewer()

// Create & add annotation.
cx=1;
cy=1;
for(int i = 0;i<NUMBER_OF_SLICES;i++) {
    def roi = new RectangleROI(cx, cy, x,y)
    def annotation = new PathAnnotationObject(roi)
    addObject(annotation)
    cx=cx+3300;
    cy=cy+3300;
}
