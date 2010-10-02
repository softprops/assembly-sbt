class AssemblySbt(info: sbt.ProjectInfo) extends sbt.PluginProject(info) with rsync.RsyncPublishing {
  def rsyncRepo = "codahale.com:/home/codahale/repo.codahale.com"
}