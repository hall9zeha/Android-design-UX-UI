package com.alain.cursos.top;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.saveable.AutoIncrementModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Number;
import java.lang.Override;
import java.lang.Short;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class Artista_Table extends ModelAdapter<Artista> {
  /**
   * Primary Key AutoIncrement */
  public static final Property<Long> id = new Property<Long>(Artista.class, "id");

  public static final Property<String> nombre = new Property<String>(Artista.class, "nombre");

  public static final Property<String> apellidos = new Property<String>(Artista.class, "apellidos");

  public static final Property<Long> fechaNacimiento = new Property<Long>(Artista.class, "fechaNacimiento");

  public static final Property<String> lugarNacimiento = new Property<String>(Artista.class, "lugarNacimiento");

  public static final Property<Short> estatura = new Property<Short>(Artista.class, "estatura");

  public static final Property<String> notas = new Property<String>(Artista.class, "notas");

  public static final Property<Integer> orden = new Property<Integer>(Artista.class, "orden");

  public static final Property<String> fotoUrl = new Property<String>(Artista.class, "fotoUrl");

  public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id,nombre,apellidos,fechaNacimiento,lugarNacimiento,estatura,notas,orden,fotoUrl};

  public Artista_Table(DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<Artista> getModelClass() {
    return Artista.class;
  }

  @Override
  public final String getTableName() {
    return "`Artista`";
  }

  @Override
  public final Artista newInstance() {
    return new Artista();
  }

  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`id`":  {
        return id;
      }
      case "`nombre`":  {
        return nombre;
      }
      case "`apellidos`":  {
        return apellidos;
      }
      case "`fechaNacimiento`":  {
        return fechaNacimiento;
      }
      case "`lugarNacimiento`":  {
        return lugarNacimiento;
      }
      case "`estatura`":  {
        return estatura;
      }
      case "`notas`":  {
        return notas;
      }
      case "`orden`":  {
        return orden;
      }
      case "`fotoUrl`":  {
        return fotoUrl;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

  @Override
  public final void updateAutoIncrement(Artista model, Number id) {
    model.setId(id.longValue());
  }

  @Override
  public final Number getAutoIncrementingId(Artista model) {
    return model.getId();
  }

  @Override
  public final String getAutoIncrementingColumnName() {
    return "id";
  }

  @Override
  public final ModelSaver<Artista> createSingleModelSaver() {
    return new AutoIncrementModelSaver<>();
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return ALL_COLUMN_PROPERTIES;
  }

  @Override
  public final void bindToInsertValues(ContentValues values, Artista model) {
    values.put("`nombre`", model.getNombre());
    values.put("`apellidos`", model.getApellidos());
    values.put("`fechaNacimiento`", model.getFechaNacimiento());
    values.put("`lugarNacimiento`", model.getLugarNacimiento());
    values.put("`estatura`", model.getEstatura());
    values.put("`notas`", model.getNotas());
    values.put("`orden`", model.getOrden());
    values.put("`fotoUrl`", model.getFotoUrl());
  }

  @Override
  public final void bindToContentValues(ContentValues values, Artista model) {
    values.put("`id`", model.getId());
    bindToInsertValues(values, model);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, Artista model, int start) {
    statement.bindStringOrNull(1 + start, model.getNombre());
    statement.bindStringOrNull(2 + start, model.getApellidos());
    statement.bindLong(3 + start, model.getFechaNacimiento());
    statement.bindStringOrNull(4 + start, model.getLugarNacimiento());
    statement.bindLong(5 + start, model.getEstatura());
    statement.bindStringOrNull(6 + start, model.getNotas());
    statement.bindLong(7 + start, model.getOrden());
    statement.bindStringOrNull(8 + start, model.getFotoUrl());
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, Artista model) {
    int start = 0;
    statement.bindLong(1 + start, model.getId());
    bindToInsertStatement(statement, model, 1);
  }

  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, Artista model) {
    statement.bindLong(1, model.getId());
    statement.bindStringOrNull(2, model.getNombre());
    statement.bindStringOrNull(3, model.getApellidos());
    statement.bindLong(4, model.getFechaNacimiento());
    statement.bindStringOrNull(5, model.getLugarNacimiento());
    statement.bindLong(6, model.getEstatura());
    statement.bindStringOrNull(7, model.getNotas());
    statement.bindLong(8, model.getOrden());
    statement.bindStringOrNull(9, model.getFotoUrl());
    statement.bindLong(10, model.getId());
  }

  @Override
  public final void bindToDeleteStatement(DatabaseStatement statement, Artista model) {
    statement.bindLong(1, model.getId());
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `Artista`(`nombre`,`apellidos`,`fechaNacimiento`,`lugarNacimiento`,`estatura`,`notas`,`orden`,`fotoUrl`) VALUES (?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `Artista`(`id`,`nombre`,`apellidos`,`fechaNacimiento`,`lugarNacimiento`,`estatura`,`notas`,`orden`,`fotoUrl`) VALUES (?,?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getUpdateStatementQuery() {
    return "UPDATE `Artista` SET `id`=?,`nombre`=?,`apellidos`=?,`fechaNacimiento`=?,`lugarNacimiento`=?,`estatura`=?,`notas`=?,`orden`=?,`fotoUrl`=? WHERE `id`=?";
  }

  @Override
  public final String getDeleteStatementQuery() {
    return "DELETE FROM `Artista` WHERE `id`=?";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `Artista`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `nombre` TEXT, `apellidos` TEXT, `fechaNacimiento` INTEGER, `lugarNacimiento` TEXT, `estatura` INTEGER, `notas` TEXT, `orden` INTEGER, `fotoUrl` TEXT)";
  }

  @Override
  public final void loadFromCursor(FlowCursor cursor, Artista model) {
    model.setId(cursor.getLongOrDefault("id"));
    model.setNombre(cursor.getStringOrDefault("nombre"));
    model.setApellidos(cursor.getStringOrDefault("apellidos"));
    model.setFechaNacimiento(cursor.getLongOrDefault("fechaNacimiento"));
    model.setLugarNacimiento(cursor.getStringOrDefault("lugarNacimiento"));
    model.setEstatura(cursor.getShortOrDefault("estatura"));
    model.setNotas(cursor.getStringOrDefault("notas"));
    model.setOrden(cursor.getIntOrDefault("orden"));
    model.setFotoUrl(cursor.getStringOrDefault("fotoUrl"));
  }

  @Override
  public final boolean exists(Artista model, DatabaseWrapper wrapper) {
    return model.getId() > 0
    && SQLite.selectCountOf()
    .from(Artista.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

  @Override
  public final OperatorGroup getPrimaryConditionClause(Artista model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(id.eq(model.getId()));
    return clause;
  }
}
