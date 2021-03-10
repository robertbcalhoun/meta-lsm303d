SUMMARY = "Example of how to build an external Linux kernel module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=1a5b8ca1c473d35c633b132f7e292f91"
# from http://www.st.com/web/catalog/tools/FM147/CL1818/SC1885/PF258118


inherit module

PR = "r0"
PV = "0.1"

SRC_URI = "file://lsm303d.c \
           file://lsm303d.h \
           file://Makefile \
           file://COPYING \
          "

# this yocto kernel recipe is needed to build kernel module tool "modpost" in linux 5.4.
# Backport it from meta/recipes-kernel if not present in your yocto branch.

DEPENDS += " make-mod-scripts"

S = "${WORKDIR}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
