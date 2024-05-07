// Import atlas annotations from ABBA to QuPath (Run for project).

setImageType('FLUORESCENCE');
clearAllObjects();
qupath.ext.biop.abba.AtlasTools.loadWarpedAtlasAnnotations(getCurrentImageData(), "name", false);

