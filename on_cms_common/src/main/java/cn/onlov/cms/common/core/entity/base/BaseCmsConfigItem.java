package cn.onlov.cms.common.core.entity.base;

import cn.onlov.cms.common.core.entity.CmsConfig;
import cn.onlov.cms.common.core.entity.CmsConfigItem;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jc_config_item table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_config_item"
 */

public abstract class BaseCmsConfigItem  implements Serializable {

	public static String REF = "CmsConfigItem";
	public static String PROP_COLS = "cols";
	public static String PROP_CONFIG = "config";
	public static String PROP_ROWS = "rows";
	public static String PROP_FIELD = "field";
	public static String PROP_DATA_TYPE = "dataType";
	public static String PROP_HELP_POSITION = "helpPosition";
	public static String PROP_PRIORITY = "priority";
	public static String PROP_HELP = "help";
	public static String PROP_CATEGORY = "category";
	public static String PROP_OPT_VALUE = "optValue";
	public static String PROP_REQUIRED = "required";
	public static String PROP_DEF_VALUE = "defValue";
	public static String PROP_ID = "id";
	public static String PROP_LABEL = "label";
	public static String PROP_SIZE = "size";


	// constructors
	public BaseCmsConfigItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsConfigItem (Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsConfigItem (
		Integer id,
		CmsConfig config,
		String field,
		String label,
		Integer priority,
		Integer dataType,
		boolean required,
		Integer category) {

		this.setId(id);
		this.setConfig(config);
		this.setField(field);
		this.setLabel(label);
		this.setPriority(priority);
		this.setDataType(dataType);
		this.setRequired(required);
		this.setCategory(category);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private String field;
	private String label;
	private Integer priority;
	private String defValue;
	private String optValue;
	private String size;
	private String rows;
	private String cols;
	private String help;
	private String helpPosition;
	private Integer dataType;
	private boolean required;
	private Integer category;

	// many to one
	private CmsConfig config;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="modelitem_id"
     */
	public Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: field
	 */
	public String getField () {
		return field;
	}

	/**
	 * Set the value related to the column: field
	 * @param field the field value
	 */
	public void setField (String field) {
		this.field = field;
	}


	/**
	 * Return the value associated with the column: item_label
	 */
	public String getLabel () {
		return label;
	}

	/**
	 * Set the value related to the column: item_label
	 * @param label the item_label value
	 */
	public void setLabel (String label) {
		this.label = label;
	}


	/**
	 * Return the value associated with the column: priority
	 */
	public Integer getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (Integer priority) {
		this.priority = priority;
	}


	/**
	 * Return the value associated with the column: def_value
	 */
	public String getDefValue () {
		return defValue;
	}

	/**
	 * Set the value related to the column: def_value
	 * @param defValue the def_value value
	 */
	public void setDefValue (String defValue) {
		this.defValue = defValue;
	}


	/**
	 * Return the value associated with the column: opt_value
	 */
	public String getOptValue () {
		return optValue;
	}

	/**
	 * Set the value related to the column: opt_value
	 * @param optValue the opt_value value
	 */
	public void setOptValue (String optValue) {
		this.optValue = optValue;
	}


	/**
	 * Return the value associated with the column: text_size
	 */
	public String getSize () {
		return size;
	}

	/**
	 * Set the value related to the column: text_size
	 * @param size the text_size value
	 */
	public void setSize (String size) {
		this.size = size;
	}


	/**
	 * Return the value associated with the column: area_rows
	 */
	public String getRows () {
		return rows;
	}

	/**
	 * Set the value related to the column: area_rows
	 * @param rows the area_rows value
	 */
	public void setRows (String rows) {
		this.rows = rows;
	}


	/**
	 * Return the value associated with the column: area_cols
	 */
	public String getCols () {
		return cols;
	}

	/**
	 * Set the value related to the column: area_cols
	 * @param cols the area_cols value
	 */
	public void setCols (String cols) {
		this.cols = cols;
	}


	/**
	 * Return the value associated with the column: help
	 */
	public String getHelp () {
		return help;
	}

	/**
	 * Set the value related to the column: help
	 * @param help the help value
	 */
	public void setHelp (String help) {
		this.help = help;
	}


	/**
	 * Return the value associated with the column: help_position
	 */
	public String getHelpPosition () {
		return helpPosition;
	}

	/**
	 * Set the value related to the column: help_position
	 * @param helpPosition the help_position value
	 */
	public void setHelpPosition (String helpPosition) {
		this.helpPosition = helpPosition;
	}


	/**
	 * Return the value associated with the column: data_type
	 */
	public Integer getDataType () {
		return dataType;
	}

	/**
	 * Set the value related to the column: data_type
	 * @param dataType the data_type value
	 */
	public void setDataType (Integer dataType) {
		this.dataType = dataType;
	}


	/**
	 * Return the value associated with the column: is_required
	 */
	public boolean isRequired () {
		return required;
	}

	/**
	 * Set the value related to the column: is_required
	 * @param required the is_required value
	 */
	public void setRequired (boolean required) {
		this.required = required;
	}


	/**
	 * Return the value associated with the column: category
	 */
	public Integer getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (Integer category) {
		this.category = category;
	}


	/**
	 * Return the value associated with the column: config_id
	 */
	public CmsConfig getConfig () {
		return config;
	}

	/**
	 * Set the value related to the column: config_id
	 * @param config the config_id value
	 */
	public void setConfig (CmsConfig config) {
		this.config = config;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof CmsConfigItem)) return false;
		else {
			CmsConfigItem cmsConfigItem = (CmsConfigItem) obj;
			if (null == this.getId() || null == cmsConfigItem.getId()) return false;
			else return (this.getId().equals(cmsConfigItem.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}