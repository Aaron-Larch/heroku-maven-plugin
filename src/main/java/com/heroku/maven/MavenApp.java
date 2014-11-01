package com.heroku.maven;

import com.heroku.api.App;
import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.util.List;

public class MavenApp extends App {

  private Log log;

  public MavenApp(String name, File targetDir, Log log) {
    super(name, targetDir);
    this.log = log;
  }

  @Override
  public void prepare(List<File> includedFiles, String jdkVersion, String jdkUrl) throws Exception {
    super.prepare(includedFiles, jdkVersion, jdkUrl);

    FileUtils.copyFile(new File(getTargetDir().getParentFile(), "pom.xml"), new File(getAppDir(), "pom.xml"));
  }

  public void logInfo(String message) {
    log.info(message);
  }

  public void logDebug(String message) {
    log.debug(message);
  }

}
