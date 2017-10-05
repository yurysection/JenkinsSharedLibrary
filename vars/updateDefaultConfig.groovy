
def updateDefaultConfig(curWorkspace, hockeyAppAppId, hockeyAppSecret, hockeyAppApiToken, serverAddress, developmentVersion, bundlePath, jobName){

    def cmd1 = 'echo Section123 | sudo -S chmod -R 777 "'+curWorkspace+'''/BloodTales/Assets";
    echo Section123 | sudo -S python "'''+curWorkspace+'''/BloodTales/tools/utilities/updateDefaultConfig.py" \
    -bundlePath "'''+bundlePath+'''" \
    -workspace "'''+curWorkspace+'''" \
    -developmentVersion '''+developmentVersion+''' \
    -serverAddress '''+serverAddress+''' \
    -hockeyAppApiToken '''+hockeyAppApiToken+''' \
    -hockeyAppAppId '''+hockeyAppAppId+''' \
    -packageId "com.section.'''+jobName+'''" \
    -hockeyAppSecret '''+hockeyAppSecret+'''
    echo Section123 | sudo -S chmod -R 777 "'''+curWorkspace+'''/BloodTales/Assets"'''
                    
    sh "$cmd1"
}
