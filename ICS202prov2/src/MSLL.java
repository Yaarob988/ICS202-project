
public class MSLL<T> {
	protected MSLLNode<T> Mhead, Mtail;
	// protected SLLNode<T> head, tail;

	public MSLL() {
		Mhead = Mtail = null;
	}

	public boolean isEmpty() {
		return Mhead == null;
	}

	public boolean isInMList(String el) {
		MSLLNode<T> tmp;
		for (tmp = Mhead; tmp != null && !tmp.info.equals(el); tmp = tmp.next)
			;
		return tmp != null;
	}

	public void addCityToSublistAtRear(City c) throws Exception {
		String st = c.getCityName();
		String st2 = st.substring(0, 1);
		if(!isInMList(st2)) {
			addToMSLLHead(st2);
		}

		MSLLNode<T> temp;
		for (temp = Mhead; temp != null && !temp.info.equals(st2); temp = temp.next)
			;
		SLLNode<City> tmp;
		for (tmp = Mhead.head; tmp != null && !tmp.info.getCityName().equals(c.getCityName()); tmp = tmp.next)
			;
		if (temp.head != null) {
			if (!(tmp != null)) {
				temp.tail.next = new SLLNode<City>(c);
				temp.tail = temp.tail.next;
			} else {
				System.out.println("1");
				throw new Exception("It is Already added");
			}
		} else {
			temp.head = temp.tail = new SLLNode<City>(c);

		}
	}

	public void addToMSLLHead(String sl) throws Exception {

		if (!isInMList(sl)) {
			Mhead = new MSLLNode<T>(sl, Mhead);
			if (Mtail == null)
				Mtail = Mhead;
		} else {
			throw new Exception(sl+" is in the list already");
		}

	}

	public void addToMSLLTail(String sl) throws Exception {
		if (!isInMList(sl)) {
			if (!isEmpty()) {
				Mtail.next = new MSLLNode<T>(sl);
				Mtail = Mtail.next;
			} else
				Mhead = Mtail = new MSLLNode<T>(sl);
		} else {
			throw new Exception(sl+" is in the list already");
		}
	}

	public void makeCitySublistEmpty(String str) throws Exception {
		if (isInMList(str)) {
			MSLLNode<T> temp = Mhead;
			while (temp != null) {
				if (temp.info.equals(str)) {
					temp.head = temp.tail = null;
					break;
				} else {
					temp = temp.next;
				}
			}
		} else {
			throw new Exception(str+" is not in the list");
		}
	}

	public boolean cityIsInSubList(City c1) {
		String st = c1.getCityName().substring(0, 1);
		MSLLNode<T> temp;
		for (temp = Mhead; temp != null && !temp.info.equals(st); temp = temp.next)
			;
		if (!(temp == null)) {
			SLLNode<City> tmp;
			for (tmp = temp.head; tmp != null && !tmp.info.getCityName().equals(c1.getCityName()); tmp = tmp.next)
				;
			return tmp != null;
		}

		return false;
	}

	public void displayCitySublist(String s1) throws Exception {
		MSLLNode<T> temp;
		for (temp = Mhead; temp != null && !temp.info.equals(s1); temp = temp.next)
			;

		if (!(temp == null)) {
			SLLNode<City> tmp;
			if(temp.head!=null) {
			for (tmp = temp.head; tmp != null; tmp = tmp.next) {
				System.out.println(tmp.info.toString());
			}
			}else {
				throw new Exception("the main list is empty");
			}
		} else {
			throw new Exception("the main list: "+s1+" does not exist");
		}
	}

	public void addToCitySublistList(City c1, int position) throws Exception {
		int counter = 1;
		String st = c1.getCityName().substring(0, 1);
		MSLLNode<T> temp;
		for (temp = Mhead; temp != null && !temp.info.equals(st); temp = temp.next)
			;
		if (temp != null) {
			SLLNode<City> tmp;
			SLLNode<City> curr = temp.head.next;
			for (tmp = temp.head; tmp != null; tmp = tmp.next, curr = curr.next, counter++) {
				if (counter == position) {
					SLLNode<City> add = new SLLNode<City>(c1);
					tmp.next = add;
					add.next = curr;
					break;
				}
			}
			if (counter != position) {
				throw new Exception("the position is invalid");
			}
		} else {
			throw new Exception("the main node does not exist");
		}
	}

	public void deleteCitySublist(String str) throws Exception {
		MSLLNode<T> temp = Mhead;
		MSLLNode<T> curr = Mhead.next;
	
		if((Mhead.next==null&&isInMList(str))) {
			Mhead=Mtail=null;
		}

		else if (isInMList(str)) {
			while (temp != null) {
				System.out.println(curr.info.equals(str));
				if (curr.info.equals(str)) {
					temp.next = curr.next;
					break;
				} else {
					temp = temp.next;
					curr = curr.next;
				}
			}
		} else {
			throw new Exception(str+" is not in the list");
		}
		}
	

	public void deleteCityFromSublist(City c1) throws Exception {
		MSLLNode<T> temp = Mhead;
		String st = c1.getCityName().substring(0, 1);
		if (isInMList(st)) {
			for (temp = Mhead; temp.next != null && !temp.info.equals(st); temp = temp.next)
				;
			if (temp.head != null && (cityIsInSubList(c1))) {
				
				SLLNode<City> tmp = temp.head;
				SLLNode<City> curr = temp.head.next;

				if (curr != null) {
					while (tmp != null) {
						if (temp.head.info.getCityName().equals(c1.getCityName())) {
							temp.head = temp.head.next;
							break;
						} else if (curr.info.getCityName().equals(c1.getCityName()) && curr != null) {
							tmp.next = curr.next;
							break;
						} else {
							temp = temp.next;
							curr = curr.next;
						}

					}
				} else {
					temp.head = temp.tail = null;
				}
				
			} else {
				throw new Exception("does not exist");
			}
		} else {
			throw new Exception("already added");
		}
	}

	public double getDistance(String city1, String city2) throws Exception {
		City c1 = getCity(city1);
		City c2 = getCity(city2);
		double long1 = c1.getDecimalLongitude();
		double long2 = c2.getDecimalLongitude();
		double short1 = c1.getDecimalLatitude();
		double short2 = c2.getDecimalLatitude();
		double pi=Math.PI;
		double r = 6372.8;
		double distance = 2 * r * Math.asin(Math.sqrt(Math.pow(Math.sin(((short2 - short1) / 2.0)*pi/180.0), 2.0)
				+ (Math.cos(short1*(pi/180.0)) * Math.cos(short2*(pi/180.0)) * Math.pow(Math.sin(((long2 - long1) / 2.0)*(pi/180.0)), 2))));
		return distance;

	}

	public City getCity(String c) throws Exception {
		String st = c.substring(0, 1);
		if (isInMList(st)) {
			MSLLNode<T> temp = Mhead;
			
			for (temp = Mhead; temp != null && !temp.info.equals(st); temp = temp.next)
				;
	
			SLLNode<City> n = temp.head;
			while (n != null) {
				
				if (n.info.getCityName().equals(c)) {
					return n.info;
				}
				n = n.next;
			}
			if (n == null) {
				throw new Exception("The city "+c +" does not exist");
			}
		} else {
			throw new Exception("the main list:"+ st+" does not exist");
		}
		return null;
	}

}
