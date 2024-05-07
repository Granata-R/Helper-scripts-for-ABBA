// 2. Export the regions contained in all the annotations of the images. 

import static qupath.lib.gui.scripting.QPEx.*
import groovy.io.FileType
import java.awt.image.BufferedImage
import qupath.lib.images.servers.ImageServerProvider
import qupath.lib.gui.commands.ProjectCommands
import qupath.lib.gui.tools.GuiTools
import qupath.lib.gui.images.stores.DefaultImageRegionStore
import qupath.lib.gui.images.stores.ImageRegionStoreFactory

server = getCurrentServer()
path = server.getPath()
print(path)
path2 = Dialogs.promptForDirectory(null)
print(path2)
downsample = 20.0
name = GeneralTools.getNameWithoutExtension(server.getMetadata().getName())
print(name)
pathOutput = buildFilePath(path2.toString(), "Downsampled_images")
print(pathOutput)
mkdirs(pathOutput)
emptyproj = buildFilePath(path2.toString(), "Project") // Creates also an empty folder for new project.
mkdirs(emptyproj)
i = 1

for (annotation in getAnnotationObjects()){
    roi = annotation.getROI()
    request = RegionRequest.createInstance(path, downsample, roi)
    writeImageRegion(server, request, pathOutput + File.separator + i + "_" + roi.toString() + '.tiff')
    i = i + 1  
}

print("Export completed!")

