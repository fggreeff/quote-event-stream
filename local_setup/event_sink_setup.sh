#!/bin/bash

# Install dependencies
echo "Installing event store locally using brew cask..."
brew cask install eventstore

# Start event store locally
echo "Starting event store locally..."
eventstore