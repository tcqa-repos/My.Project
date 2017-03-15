package PowerShell

import PowerShell.buildTypes.*
import PowerShell.vcsRoots.*
import PowerShell.vcsRoots.Powershell_HttpsGithubComJuliaReshMyProjectGit
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.ProjectFeature
import jetbrains.buildServer.configs.kotlin.v10.ProjectFeature.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.JiraIssueTracker
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.JiraIssueTracker.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.YouTrackIssueTracker
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.YouTrackIssueTracker.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.jira
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.youtrack

object Project : Project({
    uuid = "ef55c4ef-de32-49fd-bbe5-7aeb132700cf"
    extId = "PowerShell"
    parentId = "DotNet"
    name = "PowerShell"

    vcsRoot(Powershell_HttpsGithubComJuliaReshMyProjectGit)
    vcsRoot(Powershell_PowerShell)

    buildType(Powershell_RunAll)

    features {
        jira {
            id = "PROJECT_EXT_22"
            displayName = "p_TestJira"
            host = "http://tcqa-issue-trackers:8080/"
            userName = "admin"
            password = "zxx0feb335798e7f083"
            projectKeys = "JTCI"
            param("key", "jira1")
        }
        youtrack {
            id = "PROJECT_EXT_23"
            displayName = "p_Julia YT"
            host = "http://unit-539:9000/"
            userName = "root"
            password = "zxx0feb335798e7f083"
            projectExtIds = "TCI"
            param("key", "youtrack1")
        }
        versionedSettings {
            id = "PROJECT_EXT_30"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = Powershell_HttpsGithubComJuliaReshMyProjectGit.extId
            showChanges = true
            settingsFormat = VersionedSettings.Format.KOTLIN
        }
        feature {
            id = "proj_customGraph1"
            type = "project-graphs"
            param("defaultFilters", "")
            param("format", "integer")
            param("hideFilters", "")
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "Build Duration (all stages)",
                    "sourceBuildTypeId": "Powershell_RunAll",
                    "key": "BuildDuration"
                  }
                ]
            """.trimIndent())
            param("seriesTitle", "Serie")
            param("title", "New chart title")
        }
        feature {
            id = "proj_customGraph2"
            type = "project-graphs"
            param("defaultFilters", "")
            param("format", "integer")
            param("hideFilters", "")
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "Build Duration (all stages)",
                    "sourceBuildTypeId": "PowerShell_FileWithPowershellUseFile_PowerShell30",
                    "key": "BuildDuration"
                  }
                ]
            """.trimIndent())
            param("seriesTitle", "Serie")
            param("title", "Some chart")
        }
    }
})
