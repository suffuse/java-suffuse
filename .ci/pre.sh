#!/usr/bin/env bash
#

mkdir -p "$HOME/.cache"
cd "$HOME/.cache"

OSXFUSE="osxfuse-3.2.0.dmg"
URL="https://github.com/osxfuse/osxfuse/releases/download/osxfuse-3.2.0/$OSXFUSE"

[[ -f "$OSXFUSE" ]] || wget "$URL"
hdiutil mount "$OSXFUSE"
sudo installer -pkg "/Volumes/FUSE for OS X/Extras/FUSE for OS X 3.2.0.pkg" -target LocalSystem
