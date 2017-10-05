def parseP4Changelog(curWorkspace, buildPath, jenkinsHome, jobName, jobBaseName, buildNumber){

    def cmd1 = 'echo IS_APP_DATA=$(python '+curWorkspace+'''/BloodTales/tools/utilities/parseP4Changelog.py \
-changeLogPath '''+jenkinsHome+'''/jobs/$(basename $(dirname '''+jobName+'''))/jobs/'''+jobBaseName+'''/builds/'''+buildNumber+'''/changelog0.xml \
-isAppData True) > '''+buildPath+'/changelog.properties'

    def cmd2 = 'REBUILD_LIBRARY=$(python '+curWorkspace+'''/BloodTales/tools/utilities/parseP4Changelog.py \
-changeLogPath '''+jenkinsHome+'''/jobs/$(basename $(dirname '''+jobName+'''))/jobs/'''+jobBaseName+'''/builds/'''+buildNumber+'''/changelog0.xml \
-commentsContain rebuildLibrary)'''

    def cmd3 = '''if [ $REBUILD_LIBRARY == True ]; then rm -r $workspace/BloodTales/Library; else echo keeping Library; fi'''
    
    sh "mkdir -p "+buildPath
    sh "$cmd1; $cmd2; $cmd3"
}

