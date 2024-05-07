# Helper scripts for brain atlas registration with ABBA
<img src="https://i.imgur.com/EfJYnnY.png">

These helper scripts were created for the registration of the Allen Reference Atlas<sup>[1]</sup> onto immunofluorescence mouse brain sections via ABBA<sup>[2]</sup>.
The workflow assumes that the imaging file contains multiple slices (e.g., it's an entire slide). The single brain sections are first semi-automatedly matched with the corresponding atlas section using DeepSlice<sup>[3]</sup>, and then are registered and imported back in QuPath. 

## References

<sup>[1]</sup> Wang, Q., Ding, S. L., Li, Y., Royall, J., Feng, D., Lesnar, P., Graddis, N., Naeemi, M., Facer, B., Ho, A., Dolbeare, T., Blanchard, B., Dee, N., Wakeman, W., Hirokawa, K. E., Szafer, A., Sunkin, S. M., Oh, S. W., Bernard, A., Phillips, J. W., … Ng, L. (2020). The Allen Mouse Brain Common Coordinate Framework: A 3D Reference Atlas. Cell, 181(4), 936–953.e20. https://doi.org/10.1016/j.cell.2020.04.007

<sup>[2]</sup> Chiaruttini, N. ABBA - Aligning Big Brains & Atlases, https://biop.github.io/ijp-imagetoatlas/

<sup>[3]</sup> Carey, H., Pegios, M., Martin, L. et al. DeepSlice: rapid fully automatic registration of mouse brain imaging to a volumetric atlas. Nat Commun 14, 5884 (2023). https://doi.org/10.1038/s41467-023-41645-4
