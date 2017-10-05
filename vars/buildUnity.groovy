def call(curWorkspace, buildTarget, localBuildPath, appName, assetBundlesPath, bundleVersion, unityAppPath, p4_changelist, jobBaseName){

    sh ''' '''+unityAppPath+''' -quit -batchmode \
    -buildTarget '''+buildTarget+''' \
    -development true \
    -buildApp true \
    -appFilepath '''+localBuildPath+'''/'''+appName+''' \
    -assetBundles true \
    -forceAssetBundles false \
    -assetBundlesPath '''+assetBundlesPath+''' \
    -scriptingBackend IL2CPP \
    -keystorePath '''+curWorkspace+'''/BloodTales/rival.keystore \
    -keystorePass Section213 \
    -keyAlias beta \
    -keyAliasPass Section213 \
    -cacheServerEnabled false \
    -cacheServerIPAddress '10.0.1.239:8126' \
    -scriptingDefineSymbols "SECTION_DEBUG" \
    -stackTraceError ScriptOnly \
    -stackTraceAssert ScriptOnly \
    -stackTraceWarning ScriptOnly \
    -stackTraceLog ScriptOnly \
    -stackTraceException ScriptOnly \
    -deviceFilter "ARMv7" \
    -bundleVersion '''+bundleVersion+''' \
    -changeList p4_changelist \
    -bundleIdentifier com.section.jobBaseName \
    -appBasename jobBaseName \
    -localBuildPath "AssetBundles" \
    -cleanedLogFile '''+localBuildPath+'''/cleanedUnityLog.txt \
    -logFile '''+localBuildPath+'''/fullUnityLog.txt \
    -projectPath '''+curWorkspace+'''/BloodTales \
    -serial SB-22JZ-H867-NA2S-HVAY-2W86 \
    -username "iMac.builds@sectionstudios.com" \
    -password "Section!23" \
    -androidSdkRoot /Users/jenkins/AndroidUnitySdk/sdk \
    -jdk_path /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home \
    -ndk_path /Users/jenkins/android-ndk-r10e \
    -executeMethod AutoBuildScript.BuildFromCommandLine
    '''
}