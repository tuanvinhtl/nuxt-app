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
    sh 'docker build . -t tuanvinhtl/nuxt-app-1'
    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    sh 'docker push tuanvinhtl/nuxt-app-1'
}

return this