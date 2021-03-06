/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.test.formats.ogp_xml;

import com.ogprover.main.OpenGeoProver;
import com.ogprover.pp.tp.OGPTP;
import com.ogprover.pp.tp.geoconstruction.Point;
import com.ogprover.pp.tp.thmstatement.SimilarTriangles;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Class for XML converter of SimilarTriangles objects</dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public class SimilarTrianglesConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(SimilarTriangles.class);
	}

	public void marshal(Object obj, HierarchicalStreamWriter writer,
			MarshallingContext ctx) {
		SimilarTriangles statement = (SimilarTriangles)obj;
		
		writer.addAttribute("equalyoriented", (statement.areTrianglesOfSameOrientation()) ? "true" : "false");
		writer.startNode("point");
		writer.addAttribute("label", statement.getGeoObjects().get(0).getGeoObjectLabel());
		writer.endNode();
		writer.startNode("point");
		writer.addAttribute("label", statement.getGeoObjects().get(1).getGeoObjectLabel());
		writer.endNode();
		writer.startNode("point");
		writer.addAttribute("label", statement.getGeoObjects().get(2).getGeoObjectLabel());
		writer.endNode();
		writer.startNode("point");
		writer.addAttribute("label", statement.getGeoObjects().get(3).getGeoObjectLabel());
		writer.endNode();
		writer.startNode("point");
		writer.addAttribute("label", statement.getGeoObjects().get(4).getGeoObjectLabel());
		writer.endNode();
		writer.startNode("point");
		writer.addAttribute("label", statement.getGeoObjects().get(5).getGeoObjectLabel());
		writer.endNode();
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext ctx) {
		OGPTP consProtocol = OpenGeoProver.settings.getParsedTP();
		String firstTA = null, firstTB = null, firstTC = null;
		String secondTA = null, secondTB = null, secondTC = null;
		boolean equalyOriented = reader.getAttribute("equalyoriented").equals("true");
		
		if (!reader.hasMoreChildren())
			return null;
		reader.moveDown();
		if (!"point".equals(reader.getNodeName()))
			return null;
		firstTA = reader.getAttribute("label");
		reader.moveUp();
		
		if (!reader.hasMoreChildren())
			return null;
		reader.moveDown();
		if (!"point".equals(reader.getNodeName()))
			return null;
		firstTB = reader.getAttribute("label");
		reader.moveUp();
		
		if (!reader.hasMoreChildren())
			return null;
		reader.moveDown();
		if (!"point".equals(reader.getNodeName()))
			return null;
		firstTC = reader.getAttribute("label");
		reader.moveUp();
		
		if (!reader.hasMoreChildren())
			return null;
		reader.moveDown();
		if (!"point".equals(reader.getNodeName()))
			return null;
		secondTA = reader.getAttribute("label");
		reader.moveUp();
		
		if (!reader.hasMoreChildren())
			return null;
		reader.moveDown();
		if (!"point".equals(reader.getNodeName()))
			return null;
		secondTB = reader.getAttribute("label");
		reader.moveUp();
		
		if (!reader.hasMoreChildren())
			return null;
		reader.moveDown();
		if (!"point".equals(reader.getNodeName()))
			return null;
		secondTC = reader.getAttribute("label");
		reader.moveUp();
		
		if (reader.hasMoreChildren())
			return null;

		return new SimilarTriangles((Point)consProtocol.getConstructionMap().get(firstTA),
				                    (Point)consProtocol.getConstructionMap().get(firstTB),
				                    (Point)consProtocol.getConstructionMap().get(firstTC),
				                    (Point)consProtocol.getConstructionMap().get(secondTA),
				                    (Point)consProtocol.getConstructionMap().get(secondTB),
				                    (Point)consProtocol.getConstructionMap().get(secondTC), 
				                    equalyOriented);
	}
	
}