pipeline {
  agent any

  tools {nodejs "20.6.1"}

  stages {
    // stage('Install Postman CLI') {
    //   steps {
    // //bat 'powershell.exe -NoProfile -InputFormat None -ExecutionPolicy AllSigned -Command "[System.Net.ServicePointManager]::SecurityProtocol = 3072; iex ((New-Object System.Net.WebClient).DownloadString(\'https://dl-cli.pstmn.io/install/win64.ps1\'))"'

    //  // bat 'npm install -g newman'
    // //  bat 'npm i -g newman-reporter-htmlextra'

    //   }
    // }

    stage('login git hub'){
        steps{
            git 'https://github.com/omeryttnc/KesifPlus_DersAnlatim.git'
        }
    }

    stage('newman testi'){

        steps{
            bat 'newman run https://api.getpostman.com/collections/11910468-8be4b67b-2db1-4d53-811f-32d42f791e23?apikey=PMAK-6511d5b805d2900031977f25-b9b6fd199c833ca3e48395d3071084130c --environment https://api.getpostman.com/environments/11910468-3300cb8f-e7f6-4aa9-a3b9-4f7f030f2924?apikey=PMAK-6511d5b805d2900031977f25-b9b6fd199c833ca3e48395d3071084130c -d "src/test/resources/userInfo.json" -r htmlextra --reporter-htmlextra-export "src/test/resources/"'
        }
    }

  }

  post{
      always{

        emailext attachmentsPattern: 'src/test/resources/*.html', body: '', subject: 'postman raporu', to: 'omeryttnc@gmail.com'

      }
  }
}