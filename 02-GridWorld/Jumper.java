public class Jumper{
    public void jump()
    {
	Grid<Actor> gr = getGrid();
	if (gr == null)
	    return;
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	Location twoAway = next.getAdjacentLocation(getDirection());
	if (gr.isValid(twoAway))
	    moveTo(twoAway);
	else
	    removeSelfFromGrid();
    }


    public boolean canJump()
    {
	Grid<Actor> gr = getGrid();
	if (gr == null)
	    return false;
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	if (!gr.isValid(next))
	    return false;
	Actor neighbor = gr.get(next);
	if (!((neighbor == null) || (neighbor instanceof Flower)
	      || (neighbor instanceof Rock)))
	    return false;
	Location twoAway = next.getAdjacentLocation(getDirection());
	if (!gr.isValid(twoAway))
	    return false;
	neighbor = gr.get(twoAway);
	return (neighbor == null) || (neighbor instanceof Flower);
    }
}
