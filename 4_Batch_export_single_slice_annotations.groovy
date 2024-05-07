// 4. Exports all the atlas ROIs (Run for project).

import static qupath.lib.gui.scripting.QPEx.*
import groovy.io.FileType
import java.awt.image.BufferedImage
import qupath.lib.images.servers.ImageServerProvider
import qupath.lib.gui.commands.ProjectCommands
import qupath.alib.gui.tools.GuiTools
import qupath.lib.gui.images.stores.DefaultImageRegionStore
import qupath.lib.gui.images.stores.ImageRegionStoreFactory
server = getCurrentServer()
path = server.getPath()
print(path)
name = GeneralTools.getNameWithoutExtension(server.getMetadata().getName()) // Useless
print(name)
mask = buildFilePath(PROJECT_BASE_DIR, 'Atlas_annotations')
mkdirs(mask)
exportAllObjectsToGeoJson(mask + File.separator + name + ".geojson") // Important: avoid including detections. This should be array []

print('Done! Annotations saved in Atlas_annotations folder.')