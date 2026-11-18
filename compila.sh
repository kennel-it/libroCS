#!/bin/bash
JAR=/Users/edoardo/workspace-scuolaFX/ebook/target/ebook.jar
SOURCE=sorgenti
TARGET=compilati

java -Dfile.encoding=UTF8 -jar $JAR --quiet $SOURCE $TARGET --data 2025-12-31