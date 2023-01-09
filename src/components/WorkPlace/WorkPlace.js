import React from "react";
import { useParams } from "react-router-dom";
function WorkPlace() {
    const {workplaceId} =useParams();
    <div>
        User!! {workplaceId}
    </div>
}

export default WorkPlace;