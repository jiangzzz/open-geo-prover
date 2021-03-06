/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.test.formats.ogp_xml;

import com.ogprover.main.OpenGeoProver;
import com.ogprover.pp.tp.OGPTP;
import com.ogprover.pp.tp.geoconstruction.CenterOfCircle;
import com.ogprover.pp.tp.geoconstruction.Circle;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Class for XML converter of CenterOfCircle objects</dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public class CenterOfCircleConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(CenterOfCircle.class);
	}

	public void marshal(Object obj, HierarchicalStreamWriter writer,
			MarshallingContext ctx) {
		// obj is shortcut construction that is never present in CP in that form
		// (as single object) but as shortcut for some sequence of constructions, 
		// therefore no need to have marshal() method.
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext ctx) {
		OGPTP consProtocol = OpenGeoProver.settings.getParsedTP();
		String label = reader.getAttribute("label");
		String circle = reader.getAttribute("circle");
		
		return new CenterOfCircle(label, (Circle)consProtocol.getConstructionMap().get(circle));
	}
	
}