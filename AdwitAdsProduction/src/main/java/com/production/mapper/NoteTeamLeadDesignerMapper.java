package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.NoteTeamLeadDesigner;
import com.mysql.jdbc.ResultSetMetaData;

public class NoteTeamLeadDesignerMapper implements RowMapper<NoteTeamLeadDesigner> {

	@Override
	public NoteTeamLeadDesigner mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoteTeamLeadDesigner noteTeamLeadDesigner = new NoteTeamLeadDesigner();
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		for (int x = 1; x <= rsmd.getColumnCount(); x++) {
			String columnLabel = rsmd.getColumnLabel(x);
			if (columnLabel.equals("note_teamlead_designer_id"));
			noteTeamLeadDesigner.setNoteTeamLeadDesignerId(rs.getInt("note_teamlead_designer_id"));
			if (columnLabel.equals("name"));
			noteTeamLeadDesigner.setName(rs.getString("name"));
			if (columnLabel.equals("display"));
			noteTeamLeadDesigner.setDisplay(rs.getString("display"));
		}
		return noteTeamLeadDesigner;
	}
}
