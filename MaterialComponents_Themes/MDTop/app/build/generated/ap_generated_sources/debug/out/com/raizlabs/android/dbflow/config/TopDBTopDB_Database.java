package com.raizlabs.android.dbflow.config;

import com.alain.cursos.top.Artista_Table;
import com.alain.cursos.top.TopDB;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class TopDBTopDB_Database extends DatabaseDefinition {
  public TopDBTopDB_Database(DatabaseHolder holder) {
    addModelAdapter(new Artista_Table(this), holder);
  }

  @Override
  public final Class<?> getAssociatedDatabaseClassFile() {
    return TopDB.class;
  }

  @Override
  public final boolean isForeignKeysSupported() {
    return false;
  }

  @Override
  public final boolean backupEnabled() {
    return false;
  }

  @Override
  public final boolean areConsistencyChecksEnabled() {
    return false;
  }

  @Override
  public final int getDatabaseVersion() {
    return 1;
  }

  @Override
  public final String getDatabaseName() {
    return "TopDatabase";
  }
}
