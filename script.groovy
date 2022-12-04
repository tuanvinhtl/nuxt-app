def pullPackages() {
    echo 'Pulling..'
    echo "Building version ${NEW_VERSION}"
    sh 'npm install'
}

def build() {
    echo 'Building..'
    sh 'npm run build'
}

def test() {
    echo 'Test..'
}

def deploy() {
    echo 'Deploy..'
}

return this