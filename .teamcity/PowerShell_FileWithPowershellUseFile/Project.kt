package PowerShell_FileWithPowershellUseFile

import PowerShell_FileWithPowershellUseFile.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.ProjectFeature
import jetbrains.buildServer.configs.kotlin.v10.ProjectFeature.*

object Project : Project({
    uuid = "ad67521f-78da-4e5e-908c-cee82a714275"
    extId = "PowerShell_FileWithPowershellUseFile"
    parentId = "PowerShell"
    name = """"-File" with powershell.use.file"""
    description = "TW-34410"

    buildType(PowerShell_FileWithPowershellUseFile_PowerShell50)
    buildType(PowerShell_FileWithPowershellUseFile_PowerShell40)
    buildType(PowerShell_FileWithPowershellUseFile_PowerShell30)
    buildType(PowerShell_FileWithPowershellUseFile_PowerShell20)
    buildType(PowerShell_FileWithPowershellUseFile_RunAll)

    template(PowerShell_FileModeWithPowershellUseFile_FileExecutionMode)

    params {
        param("powershell.use.file", "true")
    }

    features {
        feature {
            id = "proj_customGraph1"
            type = "project-graphs"
            param("defaultFilters", "")
            param("format", "duration")
            param("hideFilters", "")
            param("properties.axis.y.includeZero", "true")
            param("properties.axis.y.max", "")
            param("properties.axis.y.min", "")
            param("properties.axis.y.type", "default")
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "BuildDuration",
                    "sourceBuildTypeId": "Powershell_RunAll",
                    "key": "BuildDuration"
                  }
                ]
            """.trimIndent())
            param("seriesTitle", "Serie")
            param("title", "Chart title")
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
                    "title": "VisibleArtifactsSize",
                    "sourceBuildTypeId": "Powershell_RunAll",
                    "key": "VisibleArtifactsSize"
                  },
                  {
                    "type": "valueType",
                    "title": "ArtifactsResolvingTime",
                    "sourceBuildTypeId": "Powershell_RunAll",
                    "key": "ArtifactsResolvingTime"
                  },
                  {
                    "type": "valueType",
                    "title": "BuildDuration",
                    "sourceBuildTypeId": "Powershell_RunAll",
                    "key": "BuildDuration"
                  },
                  {
                    "type": "valueType",
                    "title": "DuplicatorStats",
                    "sourceBuildTypeId": "Powershell_RunAll",
                    "key": "DuplicatorStats"
                  }
                ]
            """.trimIndent())
            param("seriesTitle", "Serie")
            param("title", "Chart title")
        }
        feature {
            id = "proj_customGraph3"
            type = "project-graphs"
            param("defaultFilters", "")
            param("format", "integer")
            param("hideFilters", "")
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "BuildArtifactsPublishingTime",
                    "sourceBuildTypeId": "PowerShell_FileWithPowershellUseFile_RunAll",
                    "key": "BuildArtifactsPublishingTime"
                  },
                  {
                    "type": "valueType",
                    "title": "buildStageDuration:artifactsPublishing",
                    "sourceBuildTypeId": "PowerShell_FileWithPowershellUseFile_RunAll",
                    "key": "buildStageDuration:artifactsPublishing"
                  },
                  {
                    "type": "valueType",
                    "title": "buildStageDuration:artifactsPublishing",
                    "sourceBuildTypeId": "PowerShell_FileWithPowershellUseFile_RunAll",
                    "key": "buildStageDuration:artifactsPublishing"
                  },
                  {
                    "type": "valueType",
                    "title": "BuildTestStatus",
                    "sourceBuildTypeId": "PowerShell_FileWithPowershellUseFile_RunAll",
                    "key": "BuildTestStatus"
                  },
                  {
                    "type": "valueType",
                    "title": "TimeSpentInQueue",
                    "sourceBuildTypeId": "PowerShell_FileWithPowershellUseFile_RunAll",
                    "key": "TimeSpentInQueue"
                  },
                  {
                    "type": "valueType",
                    "title": "BuildTestStatus",
                    "sourceBuildTypeId": "PowerShell_FileWithPowershellUseFile_RunAll",
                    "key": "BuildTestStatus"
                  }
                ]
            """.trimIndent())
            param("seriesTitle", "Serie")
            param("title", "New chart title")
        }
        feature {
            id = "proj_customGraph4"
            type = "project-graphs"
            param("defaultFilters", "")
            param("format", "integer")
            param("hideFilters", "")
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "buildStageDuration:artifactsPublishing",
                    "sourceBuildTypeId": "PowerShell_FileWithPowershellUseFile_PowerShell30",
                    "key": "buildStageDuration:artifactsPublishing"
                  }
                ]
            """.trimIndent())
            param("seriesTitle", "Serie")
            param("title", "New chart title")
        }
    }
})
