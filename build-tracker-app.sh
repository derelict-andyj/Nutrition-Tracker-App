#!/bin/bash
echo "Building Nutrition Tracker UI..."
docker build --rm -f "nutrition-tracker-ui/Dockerfile" -t nutritiontrackerui:latest "nutrition-tracker-ui/."