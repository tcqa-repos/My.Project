package PowerShell.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object Powershell_PowerShell : GitVcsRoot({
    uuid = "fddf3053-36e4-49d2-b56f-f3c441ed4366"
    extId = "Powershell_PowerShell"
    name = "PowerShell"
    url = "https://github.com/JuliaResh/PowerShell.git"
})
