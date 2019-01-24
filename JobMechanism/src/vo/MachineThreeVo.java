package vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "machinethree")
public class MachineThreeVo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "machine_id",length=5)
	int machineId;
	
	@Column(name = "product_in_time",length=50)
	String productInTime;
	
	@Column(name = "product_out_time",length=50)
	String productOutTime;
	
	@Column(name = "working_time",length=50)
	String workingTime;
	
	@Column(name = "waiting_time",length=50)
	String waitingTime;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="product_id",name="product_id")
	AddProductVo addProductVo;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="machine_id",name="machine_id")
	MachineTwoVo machineTwoVo;

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public String getProductInTime() {
		return productInTime;
	}

	public void setProductInTime(String productInTime) {
		this.productInTime = productInTime;
	}

	public String getProductOutTime() {
		return productOutTime;
	}

	public void setProductOutTime(String productOutTime) {
		this.productOutTime = productOutTime;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public String getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(String waitingTime) {
		this.waitingTime = waitingTime;
	}

	public AddProductVo getAddProductVo() {
		return addProductVo;
	}

	public void setAddProductVo(AddProductVo addProductVo) {
		this.addProductVo = addProductVo;
	}

	public MachineTwoVo getMachineTwoVo() {
		return machineTwoVo;
	}

	public void setMachineTwoVo(MachineTwoVo machineTwoVo) {
		this.machineTwoVo = machineTwoVo;
	}
	
	
}